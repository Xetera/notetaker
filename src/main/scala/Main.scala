import java.io.File

object Main {
  def main(args: Array[String]): Unit = {
    Actions.getEnv("GDRIVE_DIR") match {
      case None =>
        println("GDRIVE_DIR is not set!")
        System.exit(1)
      case Some(file) =>
        val target = new File("files")
        println(file)
        val out = new File(file)
        val directory = Filesystem.glob(target)
        val markdownFiles = directory.filter(Filesystem.isMarkdown)
        markdownFiles.foreach(e => Actions.toPdf(e, out))
        Actions.syncFiles(out)
    }
  }
}
