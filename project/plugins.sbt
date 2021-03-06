addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.18")

// exclude is a workaround for https://github.com/sbt/sbt-assembly/issues/236#issuecomment-294452474
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.5" exclude("org.apache.maven", "maven-plugin-api"))

addSbtPlugin("com.eed3si9n" % "sbt-unidoc" % "0.3.3")

addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC6")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")

addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.2.26")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.7.0")

addSbtPlugin("com.eed3si9n" % "sbt-doge" % "0.1.5")

addSbtPlugin("com.thesamet" % "sbt-protoc" % "0.99.11" exclude ("com.trueaccord.scalapb", "protoc-bridge_2.10"))
libraryDependencies += "com.trueaccord.scalapb" %% "compilerplugin-shaded" % "0.6.2"

libraryDependencies += "org.scala-sbt" % "scripted-plugin" % sbtVersion.value

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.0.0")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "1.1")

addSbtPlugin("com.dwijnand" % "sbt-dynver" % "2.0.0")

addSbtPlugin("com.typesafe" % "sbt-mima-plugin" % "0.1.15")
