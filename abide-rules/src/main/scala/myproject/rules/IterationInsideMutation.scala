package myproject.rules

import scala.tools.abide.Context
import scala.tools.abide.traversal.ScopingRule

class IterationInsideMutation(val context: Context) extends ScopingRule {
  import context.universe._

  type Owner = Tree
  val name = "IterationInsideMutation"

  case class Warning(pos: Position, message: String, tree: Tree) extends RuleWarning

  val iterationMethods = Set("foreach", "map", "filter", "flatMap").map { x => TermName(x) }
  val mutationMethods  = Set("remove", "update", "-=").map(TermName.apply)

  val step = optimize {
    case tree @ q"$qual.$method[..$tps](..$args)" =>
      if (iterationMethods(method.decodedName))
        enter(qual)
      else if (mutationMethods(method.decodedName) && (state.in(_.equalsStructure(qual))))
        nok(Warning(tree.pos, s"Avoid mutation while iterating over `$qual`", qual))
  }
}
