package team08

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class IndexComposer extends GrailsComposer {

    def afterCompose = { window ->




        $('#btnsigin').on('Click',{

	    	if($('#userid').size() == 0 ){
	    		alert ("ไม่มี")
	    	}else{
		    	def finddata = $('#userid')[0].text	
		    	def employee_data = Employee.findByIdem(finddata)

	  			if(employee_data == null){
	       			alert("ไม่มีข้อมูล กรุณาตรวจสอบอีกครั้ง")
	       		}
	        	else{
	        		if(employee_data.calssem == "")
	        		alert("พบข้อมูลพนักงาน")
	        	}
	    	}

	    })
			

		$('#btncancle').on('Click',{

	        alert("cancle")
	    })
        
    }
}
