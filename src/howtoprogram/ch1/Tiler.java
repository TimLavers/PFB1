package howtoprogram.ch1;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Tiler {

    private int pictureSize = 512;
    private int[][] tileColors;

    public Tiler(int[][] tileColors) {
        this.tileColors = tileColors;
    }

    public Canvas setUpPicture() {
        Canvas canvas = new Canvas(pictureSize, pictureSize);
        //todo warning if not square
        //todo warning if side length not power of 2
        int numberOfTilesPerSide = tileColors.length;
        int sizeOfEachTile = pictureSize / numberOfTilesPerSide;
        GraphicsContext graphics = canvas.getGraphicsContext2D();//Does the drawing.
        for (int row=0; row<numberOfTilesPerSide; row++) {
            for (int column=0; column<numberOfTilesPerSide; column++) {
                int offsetX = column * sizeOfEachTile;
                int offsetY = row * sizeOfEachTile;
                int intensity = tileColors[row][column];
                Color tileColor = Color.rgb(intensity, intensity, intensity);
                graphics.setFill(tileColor);
                graphics.fillRect(offsetX, offsetY, sizeOfEachTile, sizeOfEachTile);
            }
        }
        return canvas;
    }
}