package team08

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class RegMemberComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here

        $('#x1').on('click',{
        	alert("ท่านกำลังจะเข้าสู้หน้าลงทะเบียนแบบสมาชิกทั่วไป")
        	$('#qua').setOpen(false)
        	$('#normal').setOpen(true)
        })
        $('#x2').on('click',{
        	alert("ท่านกำลังจะเข้าสู้หน้าลงทะเบียนแบบสมาชิก VIP")
        	$('#qua').setOpen(false)
        	$('#normal').setOpen(false)
        	$('#vip').setOpen(true)
        })
    }
}
