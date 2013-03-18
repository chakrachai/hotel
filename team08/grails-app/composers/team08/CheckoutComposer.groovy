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
		int roommony = 15000
		int	countmonny = 0	
        $('#search').on('click',{
		c=$('#idc')[0].getText()		
		b=MemberCustomer.findByMemberId(c)
		e=Room.findAllByCustomer(b)
        	
			$('#name')[0].setValue(b.fName+" "+b.lName)
			$('#email')[0].setValue(b.emailAddress)
			$('#tel')[0].setValue(b.telNo)
			
			//int daycount = 0
			//for(loop in e){
				$('#dateI').setValue(e.dayIn)
				$('#dateO').setValue(e.dayOut)
			//}						
        $('#idc').setText("")
    $('#service').append{
        for(loopin in Room.findAllByCustomer(b)){
        	if(loopin.roomStatus=="ว่าง"){
        countmonny = countmonny+roommony
        		listitem(value:loopin.id){
                    listcell{   
                        label(value:loopin.roomNo)
                	}
                	listcell{   
                        label(value:"ค่าบริการ")
                	}
                	listcell{   
                        label(value:roommony+"")
                	}
                	listcell{   
                        label(value:roommony+"")
                	}
            	}
        	}

        }
        }
        	$('#money')[0].text = countmonny+""	
        	$('#payment')[0].setValue(countmonny+"")

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
			for(loopin2 in e){
				loopin2.delete()
			}
			alert("save")
			$('#service > listitem').detach()	
		})
		
		$('#btnPrint').on('click','''
			window.print(alert("ปริ้นหน้านี้"));
			
		''')
		
		$('#btnExit').on('click',{
			def searchData = DataSignIn.get(2)
			searchData.datainput = ""
            searchData.save()
	    	Executions.sendRedirect("/index.zul")
	    	alert("เสร็จเรียบร้อยคะ")
	    })
    }
}

