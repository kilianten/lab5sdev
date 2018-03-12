
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._
/*1.2*/import models.products.Category
/*2.2*/import models.products.Product
/*3.2*/import models.users.User

object listProducts extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[List[Product],List[Category],Long,String,User,play.api.Environment,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(products: List[Product], categories: List[Category], catId: Long, filter: String,user: User,env: play.api.Environment):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.121*/("""


"""),_display_(/*7.2*/main("Products",user)/*7.23*/ {_display_(Seq[Any](format.raw/*7.25*/("""

"""),format.raw/*9.1*/("""<p class="lead">Product Catalogue</p>
<br>
<div class="row">
  <div class="col-sm-2">
    <h4>Categories</h4>
    <div class="list-group">
      <a href=""""),_display_(/*15.17*/routes/*15.23*/.ProductCtrl.listProducts(0, filter)),format.raw/*15.59*/("""" class="list-group-item">All Categories</a>
      """),_display_(/*16.8*/for(c <- categories) yield /*16.28*/ {_display_(Seq[Any](format.raw/*16.30*/("""
        """),format.raw/*17.9*/("""<a href=""""),_display_(/*17.19*/routes/*17.25*/.ProductCtrl.listProducts(c.getId, filter)),format.raw/*17.67*/("""" class="list-group-item">"""),_display_(/*17.94*/c/*17.95*/.getName),format.raw/*17.103*/("""
          """),format.raw/*18.11*/("""<span class="badge">"""),_display_(/*18.32*/c/*18.33*/.getProducts.size()),format.raw/*18.52*/("""</span>
        </a>
      """)))}),format.raw/*20.8*/("""
    """),format.raw/*21.5*/("""</div>
  </div>
  <div class="col-sm-10">
      """),_display_(/*24.8*/if(flash.containsKey("success"))/*24.40*/ {_display_(Seq[Any](format.raw/*24.42*/("""
        """),format.raw/*25.9*/("""<div class="alert alert-success">
          """),_display_(/*26.12*/flash/*26.17*/.get("success")),format.raw/*26.32*/("""
        """),format.raw/*27.9*/("""</div>
      """)))}),format.raw/*28.8*/("""
      """),_display_(/*29.8*/if(flash.containsKey("failed"))/*29.39*/{_display_(Seq[Any](format.raw/*29.40*/("""
        """),format.raw/*30.9*/("""<div class="alert alert-failed">
          """),_display_(/*31.12*/flash/*31.17*/.get("failed")),format.raw/*31.31*/("""
        """),format.raw/*32.9*/("""</div>
      """)))}),format.raw/*33.8*/("""

      			"""),format.raw/*35.10*/("""<!-- Search Form -->
			<div id="actions">
        <form action=""""),_display_(/*37.24*/routes/*37.30*/.ProductCtrl.listProducts(catId)),format.raw/*37.62*/("""" method="GET">
         <input type="search" id="searchbox" name="filter" value=""""),_display_(/*38.68*/filter),format.raw/*38.74*/("""" placeholder="Filter by product name...">
         <input type="submit" id="searchsubmit" value="Filter by name" class="btn-md btn-primary">
        </form>
       </div>
    <table class="table table-bordered table-hover table-condensed">   
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Description</th>
          <th>Stock</th>
          <th>Price</th>   
        </tr>
      </thead>

      <tbody>
        """),_display_(/*54.10*/for(p<-products) yield /*54.26*/ {_display_(Seq[Any](format.raw/*54.28*/("""
          """),format.raw/*55.11*/("""<tr>
              """),_display_(/*56.16*/if(env.resource("public/images/productImages/thumbnails/" + p.getId + ".jpg").isDefined)/*56.104*/ {_display_(Seq[Any](format.raw/*56.106*/("""
                """),format.raw/*57.17*/("""<td><img src="/assets/images/productImages/thumbnails/"""),_display_(/*57.72*/(p.getId + ".jpg")),format.raw/*57.90*/(""""/></td>
            """)))}/*58.15*/else/*58.20*/{_display_(Seq[Any](format.raw/*58.21*/("""
                """),format.raw/*59.17*/("""<td><img src="/assets/images/productImages/thumbnails/noImage.jpg"/></td>
            """)))}),format.raw/*60.14*/("""
            """),format.raw/*61.13*/("""<td class="numeric">"""),_display_(/*61.34*/p/*61.35*/.getId),format.raw/*61.41*/("""</td>
            <td><a href=""""),_display_(/*62.27*/routes/*62.33*/.ProductCtrl.productDetails(p.getId)),format.raw/*62.69*/("""">
                """),_display_(/*63.18*/p/*63.19*/.getName),format.raw/*63.27*/("""</td>
               </a>     
            <td>"""),_display_(/*65.18*/p/*65.19*/.getDescription),format.raw/*65.34*/("""</td>
            <td  class="numeric">"""),_display_(/*66.35*/p/*66.36*/.getStock),format.raw/*66.45*/("""</td>
            <td  class="numeric">€ """),_display_(/*67.37*/("%.2f".format(p.getPrice))),format.raw/*67.64*/("""</td>
            <td> """),_display_(/*68.19*/if(p.getStock > 0)/*68.37*/{_display_(Seq[Any](format.raw/*68.38*/("""<a href=""""),_display_(/*68.48*/routes/*68.54*/.ShoppingCtrl.addToBasket(p.getId)),format.raw/*68.88*/(""""  class="btn btn-default btn-xs"><span class="glyphicon glyphicon-shopping-cart"></span></a>""")))}),format.raw/*68.182*/("""</td>

          </tr>
        """)))}),format.raw/*71.10*/("""
      """),format.raw/*72.7*/("""</tbody>

    </table>
  </div>
</div>
""")))}))
      }
    }
  }

  def render(products:List[Product],categories:List[Category],catId:Long,filter:String,user:User,env:play.api.Environment): play.twirl.api.HtmlFormat.Appendable = apply(products,categories,catId,filter,user,env)

  def f:((List[Product],List[Category],Long,String,User,play.api.Environment) => play.twirl.api.HtmlFormat.Appendable) = (products,categories,catId,filter,user,env) => apply(products,categories,catId,filter,user,env)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 09 12:30:28 GMT 2018
                  SOURCE: /home/wdd/webapps/lab5/app/views/listProducts.scala.html
                  HASH: 0e5ce4ceaeb9615971a76809ff521d875d2a701b
                  MATRIX: 651->1|690->34|728->66|1124->92|1339->211|1368->215|1397->236|1436->238|1464->240|1646->395|1661->401|1718->437|1796->489|1832->509|1872->511|1908->520|1945->530|1960->536|2023->578|2077->605|2087->606|2117->614|2156->625|2204->646|2214->647|2254->666|2312->694|2344->699|2419->748|2460->780|2500->782|2536->791|2608->836|2622->841|2658->856|2694->865|2738->879|2772->887|2812->918|2851->919|2887->928|2958->972|2972->977|3007->991|3043->1000|3087->1014|3126->1025|3219->1091|3234->1097|3287->1129|3397->1212|3424->1218|3905->1672|3937->1688|3977->1690|4016->1701|4063->1721|4161->1809|4202->1811|4247->1828|4329->1883|4368->1901|4409->1924|4422->1929|4461->1930|4506->1947|4624->2034|4665->2047|4713->2068|4723->2069|4750->2075|4809->2107|4824->2113|4881->2149|4928->2169|4938->2170|4967->2178|5042->2226|5052->2227|5088->2242|5155->2282|5165->2283|5195->2292|5264->2334|5312->2361|5363->2385|5390->2403|5429->2404|5466->2414|5481->2420|5536->2454|5662->2548|5725->2580|5759->2587
                  LINES: 24->1|25->2|26->3|31->4|36->4|39->7|39->7|39->7|41->9|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17|49->17|49->17|49->17|49->17|50->18|50->18|50->18|50->18|52->20|53->21|56->24|56->24|56->24|57->25|58->26|58->26|58->26|59->27|60->28|61->29|61->29|61->29|62->30|63->31|63->31|63->31|64->32|65->33|67->35|69->37|69->37|69->37|70->38|70->38|86->54|86->54|86->54|87->55|88->56|88->56|88->56|89->57|89->57|89->57|90->58|90->58|90->58|91->59|92->60|93->61|93->61|93->61|93->61|94->62|94->62|94->62|95->63|95->63|95->63|97->65|97->65|97->65|98->66|98->66|98->66|99->67|99->67|100->68|100->68|100->68|100->68|100->68|100->68|100->68|103->71|104->72
                  -- GENERATED --
              */
          