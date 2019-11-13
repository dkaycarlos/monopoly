package engine;

import monopoly.util.Timer;
import org.lwjgl.glfw.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;

public class GameEngine{

    private Window window;
    private IGameLogic gameLogic;

    private Timer timer;

    private final int TARGET_UPS = 30;

    private GLFWKeyCallback keyCallback = new GLFWKeyCallback() {
        @Override
        public void invoke(long windowID, int key, int scancode, int action, int mods) {
            gameLogic.input(key, scancode, action, mods);
        }
    };

    public GameEngine(String title, int width, int height, boolean vSync, IGameLogic gameLogic) {
        this.window = new Window(title, width, height, vSync);
        this.gameLogic = gameLogic;
        timer = new Timer();
    }

    public void run() {
        try {
            init();
            loop();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cleanup();
        }
    }

    private void init() throws  Exception {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        window.createWindow();

        glfwSetKeyCallback(window.getId(), keyCallback);

        glfwShowWindow(window.getId());

        gameLogic.init(window);
        timer.init();
    }

    private void loop() {
        double delta;
        double accumulator = 0.0;
        double interval = 1.0 / TARGET_UPS;
        double alpha;

        while (!glfwWindowShouldClose(window.getId())) {
            delta = timer.getDeltaTime();
            accumulator += delta;

            glfwPollEvents();
            while (accumulator >= interval) {
                gameLogic.update();
                accumulator -= interval;
            }

            alpha = accumulator / interval;

            gameLogic.render(alpha);
        }
    }

    public void cleanup() {
        gameLogic.cleanup();

        glfwFreeCallbacks(window.getId());
        glfwDestroyWindow(window.getId());

        glfwTerminate();
    }
}
