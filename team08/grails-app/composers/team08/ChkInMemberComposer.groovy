package team08

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class ChkInMemberComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here
        $('#chkx').on('click',{
            $('#g1').setOpen(false)
            $('#g2').setOpen(true)
    	})
    	$('#backx').on('click',{
            $('#g2').setOpen(false)
            $('#g1').setOpen(true)
    	})
    	
    }
}
