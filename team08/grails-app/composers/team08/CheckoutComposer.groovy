package team08
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class CheckoutComposer extends GrailsComposer {

    def afterCompose = { window ->
		def b
		def e
		String c 		
        $('#search').on('click',{
		c=$('#idc')[0].getText()		
		b=MemberCustomer.findByMemberId(c)
		e=Room.findByCustomer(b)
        	
			$('#name')[0].setValue(b.fName+" "+b.lName)
			$('#email')[0].setValue(b.emailAddress)
			$('#tel')[0].setValue(b.telNo)
			$('#dateI').setValue(e.dayIn)
			$('#dateO').setValue(e.dayOut)
			
						
        $('#idc').setText("")
		})
		
		
		def money1=$('#money').getText()
		
		def cradit=$('#cradit').getText()
		
		
		$('#btnSave').on('click',{
			def savemoney = new MonyService(
				dateIn:e.dayIn,
				dateOut:e.dayOut,
				money:money1,
				cradit:cradit,
				priceroom: "ooi"
			)
			savemoney.save()
			alert("save")	
		})
		
		
		$('#btnPrint').on('click','''
			window.print();
		''')
		
		$('#btnExit').on('click',{
	    	Executions.sendRedirect("/index.zul")
	    	alert("เสร็จเรียบร้อยคะ")
	    })
        
		 	
		
			
			
		 
    }
}

