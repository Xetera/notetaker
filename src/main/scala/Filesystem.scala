import java.io.File

object Filesystem {
  final val fileSplitToken = """\."""

  def glob(file: File): Array[File] = file match {
    case f if f.isDirectory => f.listFiles().flatMap(glob)
    case f => Array(f)
  }

  def isMarkdown(file: File): Boolean =
    file.getName.split(fileSplitToken).last == "md"

  def createFileDirs(file: File): Unit =
    file.getParentFile.mkdirs()

  def convertMdLocations(path: String, baseName: String): String = path
    .replaceFirst("files/", s"$baseName/")
    .replaceFirst(".md", ".pdf")
}
