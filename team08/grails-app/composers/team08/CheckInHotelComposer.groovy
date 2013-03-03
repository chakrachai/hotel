package team08

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class CheckInHotelComposer extends GrailsComposer {

    def afterCompose = { window ->

        def searchData = DataSignIn.get(2)
        alert(searchData.datainput)
        def employeedata = searchData.datainput
        searchData.datainput = ""
        searchData.save()
    	$('#searchCustomer').on('click',{
    		def datacustomer = $('#customerId')[0].text
    		def customer = MemberCustomer.findByMemberId(datacustomer)
    		if(customer == null){
    			alert("ไม่พบข้อมูล")
    		}else{
    			$('#customerName')[0].text=customer.fName
				$('#customerLastname')[0].text=customer.lName    			
				$('#passport')[0].text=customer.idCityzen

                $('#searchCustomer').detach()
    		}
    	})
//==================================================find and show dataCustomer==========================================================
        $('#btnsingout').on('click',{
            alert(employeedata)
        })
    }
}
