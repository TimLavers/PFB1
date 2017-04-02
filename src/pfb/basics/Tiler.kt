package pfb.basics

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class Tiler(private val tileColors: Array<Array<Int>>) {

    private val pictureSize = 200

    fun setUpPicture(): Canvas {
        val canvas = Canvas(pictureSize.toDouble(), pictureSize.toDouble())
        val numberOfTilesPerSide = tileColors.size
        val sizeOfEachTile = pictureSize / numberOfTilesPerSide
        val graphics = canvas.graphicsContext2D//Does the drawing.
        for (row in 0..numberOfTilesPerSide - 1) {
            for (column in 0..numberOfTilesPerSide - 1) {
                val offsetX = column * sizeOfEachTile
                val offsetY = row * sizeOfEachTile
                val intensity = tileColors[row][column]
                val tileColor = Color.rgb(intensity, intensity, intensity)
                graphics.fill = tileColor
                graphics.fillRect(offsetX.toDouble(), offsetY.toDouble(), sizeOfEachTile.toDouble(), sizeOfEachTile.toDouble())
            }
        }
        return canvas
    }
}