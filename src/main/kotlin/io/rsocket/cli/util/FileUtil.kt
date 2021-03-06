package io.rsocket.cli.util

import io.rsocket.cli.UsageException
import java.io.File

object FileUtil {
  fun expectedFile(name: String): File {
    val file = File(normalize(name))

    if (!file.isFile) {
      throw UsageException("file not found: " + file)
    }

    return file
  }

  private fun normalize(path: String): String = when {
    path.startsWith("~/") -> System.getenv("HOME") + "/" + path.substring(2)
    else -> path
  }
}
