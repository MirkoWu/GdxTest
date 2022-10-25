package com.mirkowu.core;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Draw extends ApplicationAdapter {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Pixmap pixmap;
    private Texture texture;
    private int radius = 5;
    //private JFileChooser fileChooser;

    @Override
    public void create() {
        batch = new SpriteBatch();

        //init white board
        pixmap = new Pixmap(500, 480, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();

        //init paint
        pixmap.setColor(Color.BLACK);


        texture = new Texture(pixmap);

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                System.out.println("keycode = " + keycode);
                updateColor(keycode);
                updatePaintSize(keycode);
                if (keycode == Input.Keys.S) saveFile();
                return super.keyDown(keycode);
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                System.out.println("screenX = " + screenX + ", screenY = " + screenY + ", pointer = " + pointer + ", button = " + button);
                draw(screenX, screenY);
                return super.touchDown(screenX, screenY, pointer, button);
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                System.out.println("screenX = " + screenX + ", screenY = " + screenY + ", pointer = " + pointer);
                draw(screenX, screenY);
                return super.touchDragged(screenX, screenY, pointer);
            }
        });

        //camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();


    }

    private void draw(int screenX, int screenY) {
        pixmap.fillCircle(screenX, screenY, radius);
        texture.draw(pixmap, 0, 0);
    }

    private void updatePaintSize(int keycode) {
        switch (keycode) {
            case Input.Keys.NUM_1:
                radius = 5;
                break;
            case Input.Keys.NUM_2:
                radius = 10;
                break;
            case Input.Keys.NUM_3:
                radius = 20;
                break;
        }
    }

    private void updateColor(int keycode) {
        switch (keycode) {
            case Input.Keys.R:
                pixmap.setColor(Color.RED);
                break;
            case Input.Keys.G:
                pixmap.setColor(Color.GREEN);
                break;
            case Input.Keys.B:
                pixmap.setColor(Color.BLUE);
                break;
            case Input.Keys.Y:
                pixmap.setColor(Color.YELLOW);
                break;
            case Input.Keys.W:
                pixmap.setColor(Color.WHITE);
                break;
        }
    }

    private void saveFile() {

    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.WHITE);
//
//        //白色清屏
//        Gdx.gl.glClearColor(1, 1, 1, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

camera.update();


        batch.begin();
        batch.draw(texture, 0, 0);
        batch.end();

        //控制ð
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

        }
    }

    @Override
    public void dispose() {
        pixmap.dispose();
        texture.dispose();
        batch.dispose();
    }
}
