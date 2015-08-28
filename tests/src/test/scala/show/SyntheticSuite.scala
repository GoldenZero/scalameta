import org.scalatest._
import scala.meta.internal.ast._
import scala.meta.internal.flags._
import scala.meta.internal.semantic._
import scala.meta.internal.ui.Attributes

class SyntheticSuite extends ParseSuite {
  test("comprehensive show[Attributes]") {
    val symbolroot = Symbol.RootPackage
    val prefixroot = Prefix.Zero
    val denotroot = Denotation.Single(prefixroot, symbolroot)
    val expansionroot = Expansion.Identity
    val termroot = Term.Name("_root_").withDenot(denotroot).withRecursiveTyping.withExpansion(expansionroot).setTypechecked
    val typeroot = Type.Singleton(termroot).setTypechecked

    val symbolBar = Symbol.Global(symbolroot, "Bar", Signature.Type)
    val prefixBar = Prefix.Type(typeroot)
    val denotBar = Denotation.Single(prefixBar, symbolBar)
    val typeBar = Type.Name("Bar").withDenot(denotBar).setTypechecked

    val symbolbar = Symbol.Local("bar")
    val prefixbar = Prefix.Zero
    val denotbar = Denotation.Single(prefixbar, symbolbar)
    val typebar = typeBar
    val expansionbar = Expansion.Identity
    val termbar = Term.Name("bar").withDenot(denotbar).withTyping(typebar).withExpansion(expansionbar).setTypechecked

    val symbolx = Symbol.Local("x")
    val prefixx = Prefix.Zero
    val denotx = Denotation.Single(prefixx, symbolx)
    val typex = typeBar
    val expansionx = termbar
    val x = Term.Name("x").withDenot(denotx).withTyping(typex).withExpansion(expansionx)

    assert(x.show[Attributes] === """
      |Term.Name("x")[1]{1}<1>*
      |[1] {0}::local#x
      |[2] {0}::local#bar
      |[3] {2}::_root_#Bar
      |[4] {0}::_root_
      |{1} Type.Name("Bar")[3]
      |{2} Type.Singleton(Term.Name("_root_")[4]{3}<>)
      |<1> Term.Name("bar")[2]{1}<>
    """.trim.stripMargin)
  }
}
