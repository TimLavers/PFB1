package pfb.basics

import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import java.io.FileInputStream

fun main(args: Array<String>) {
    FirstProgram().doLaunch(args)
}
class FirstProgram : Application() {

    fun tileColors() :  Array<Array<Int>> {
        return arrayOf(
                arrayOf(0, 255),
                arrayOf(255, 0)
        )
    }

    override fun start(primaryStage: Stage) {
        val tiler = Tiler(tileColors())
        val canvas = tiler.setUpPicture()
        val root = Group(canvas)
        val scene = Scene(root)
        primaryStage.scene = scene
        primaryStage.show()
        val icon = Image(FileInputStream("./src/pfb/basics/icon.png"))
        primaryStage.icons.add(icon)
        primaryStage.title = "Basics"
    }

    fun doLaunch(args: Array<String>) {
        Application.launch(*args)
    }

    override fun init() {

        super.init()
    }
}