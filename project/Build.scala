import sbt._

object ScalaEulerBuild extends Build {
  lazy val root = Project(
    id = "main",
    base = file(".")
  ) aggregate(project1, project2) dependsOn(project1, project2)

  lazy val project1 = Project(
    id = "eulerlib",
    base = file("eulerlib")
  )

  lazy val project2 = Project(
    id = "problems",
    base = file("problems")
  ) aggregate(project1) dependsOn(project1)
}
