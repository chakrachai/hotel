package team08
import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class IndexComposer extends GrailsComposer {

    def afterCompose = { window ->
        $('#btnsigin').on('Click',{

	    	if($('#userid').size() == 0 ){
	    		alert ("ไม่มี")
	    		$('#userid')[0].text = ""
	    		$('#passwordid')[0].text = ""
	    	}else{
		    	def finddata = $('#userid')[0].text	
		    	def employee_data = Employee.findByIdem(finddata)

	  			if(employee_data == null){
	       			alert("ไม่มีข้อมูล กรุณาตรวจสอบอีกครั้ง")
	       			$('#userid')[0].text = ""
	       			$('#passwordid')[0].text = ""
	       		}
	        	else{
	        		if(employee_data.classem == "Cashier"){
	        			if($('#passwordid')[0].text == employee_data.passem){
	        				def outdata = new DataSignIn(datainput:finddata).save()
	        				Executions.sendRedirect("/checkInHotel.zul")
	        				alert("ยินดีต้อนรับ")
	        			}else{
	        				alert("รหัสไม่ถูกต้อง")
	        				$('#userid')[0].text = ""
	        				$('#passwordid')[0].text = ""
	        			}
	        		}else {
	        			alert("กรุณาตรวจสอบ้อมูล")
	        			$('#userid')[0].text = ""
	        			$('#passwordid')[0].text = ""
	        		}
	        		
	        	}
	    	}

	    })
			

		$('#btncancle').on('Click',{

	        alert("cancle")
	    })
        
    }
}
