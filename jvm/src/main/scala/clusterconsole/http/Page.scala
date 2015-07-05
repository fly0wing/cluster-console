package clusterconsole.http

import scalatags.Text.all.{ html => htmlFrag, _ }
import scalatags.Text.tags2

object Page {
  private[Page] def headTag(title: String) =
    head(
      tags2.title(id := "title")(title),
      meta(name := "viewport", content := "width=device-width, initial-scale=1.0")
    )

  def main(title: String, content: Frag*) =
    htmlFrag(
      headTag(title),
      body(onload := "ClusterConsoleApp().main()")(
        script(src := "/js/cluster-console-jsdeps.js"),
        script(src := "/js/cluster-console-fastopt.js")
      )
    )
}
