package acavailhez.html.bootstrap

import acavailhez.html.AbstractTest
import acavailhez.html.Html
import acavailhez.html.traits.bootstrap.Bootstrap4ButtonStyle
import acavailhez.html.traits.bootstrap.Bootstrap4Trait
import org.junit.Test

public class BootstrapModalTest extends AbstractTest {

    static abstract class BootstrapHtml extends Html implements Bootstrap4Trait {}

    @Test
    public void testEmpty() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                bootstrapModal([:]) {

                }
            }
        }).getRawHtml()

        assert renderEquals(html, '''
 <div class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog">
   <div class="modal-content">
    <div class="modal-header">
     <button type="button" class="close" data-dismiss="modal">
      <span aria-hidden="true">&times;</span>
     </button>
    </div>
    <div class="modal-body">
    </div>
   </div>
  </div>
 </div>
''')
    }

    @Test
    public void testTitle() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                bootstrapModal([title: 'A nice title', tabindex: 2]) {

                }
            }
        }).getRawHtml()

        assert renderEquals(html, '''
 <div class="modal fade" tabindex="2" role="dialog">
  <div class="modal-dialog">
   <div class="modal-content">
    <div class="modal-header">
     <button type="button" class="close" data-dismiss="modal">
      <span aria-hidden="true">&times;</span>
     </button>
     <h4 class="modal-title">A nice title</h4>
    </div>
    <div class="modal-body">
    </div>
   </div>
  </div>
 </div>
''')
    }

    @Test
    public void testBootstrapExample() throws Exception {
        String html = (new BootstrapHtml() {
            @Override
            public void build() {
                bootstrapModal(title: "Modal title", closeLabel: "Close") {
                    p("One fine body…")
                } {
                    bootstrapButton("Close", 'data-dismiss': 'modal')
                    bootstrapButton("Save changes", btnStyle: Bootstrap4ButtonStyle.PRIMARY)
                }
            }
        }).getRawHtml()

        assert renderEquals(html, '''
<div class="modal fade" tabindex="-1" role="dialog">
 <div class="modal-dialog">
   <div class="modal-content">
     <div class="modal-header">
       <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
       <h4 class="modal-title">Modal title</h4>
     </div>
     <div class="modal-body">
       <p>One fine body&hellip;</p>
     </div>
     <div class="modal-footer">
       <button data-dismiss="modal" type="button" class="btn btn-default">Close</button>
       <button type="button" class="btn btn-primary">Save changes</button>
     </div>
   </div>
 </div>
</div>
''')
    }
}