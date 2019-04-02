import java.io.File

import Filesystem.{convertMdLocations, createFileDirs}
import sys.process._

object Actions {
  def getEnv(name: String): Option[String] = System.getenv(name) match {
    case env: String => Some(env)
    case null => None
  }

  def toPdf(in: File, out: File): Int = {
    val pandocOpts = getEnv("PANDOC_OPTIONS").getOrElse("")
    val inPath = in.getPath
    val outLocation = convertMdLocations(inPath, out.getName)
    createFileDirs(new File(outLocation))
    s"pandoc $pandocOpts $inPath -o $outLocation".!
  }

  def syncFiles(file: File): Unit = {
    getEnv("GDRIVE_REFRESH_TOKEN") match {
      case None =>
        println("GDRIVE_REFRESH_TOKEN is not set!")
        System.exit(1)
      case Some(refresh) =>
        s"gdrive upload --refresh-token $refresh ./${file.getName} --recursive".!
    }
  }
}
