package team08
import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions

import org.*
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
	        				def outdata = DataSignIn.findById("2")
	        					outdata.datainput = $('#userid')[0].text
	        					outdata.save()
	        					$('#showlogin').setVisible(false)
								$('#showmenu').setVisible(true)
	        			}			
	        			else{
	        				alert("รหัสไม่ถูกต้อง")
	        				$('#userid')[0].text = ""
	        				$('#passwordid')[0].text = ""
	        			}
	        		}else if(employee_data.classem == "CEO"){
	        			if($('#passwordid')[0].text == employee_data.passem){
	        				def outdata = DataSignIn.findById("2")
	        					outdata.datainput = $('#userid')[0].text
	        					outdata.save()
	        					Executions.sendRedirect("/employee.zul")
	    						alert("ยินดีต้อนรับ")
		        			}			
	        			else{
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
		

		$('#btnroomfix').on('Click',{
	    	Executions.sendRedirect("/checkInHotel.zul")
	    	alert("ยินดีต้อนรับ")
	    })

		$('#btnmoney').on('Click',{
	    	Executions.sendRedirect("/checkout.zul")
	    	alert("ยินดีต้อนรับ")
	    })

		$('#btnroomevent').on('Click',{
	    	Executions.sendRedirect("/roomevent.zul")
	    	alert("ยินดีต้อนรับ")
	    })

	    $('#btncustomer').on('Click',{
	    	Executions.sendRedirect("/regMember.zul")
	    	alert("ยินดีต้อนรับ")
	    })
		$('#btncancle').on('Click',{
			$('#userid')[0].text = ""
	       	$('#passwordid')[0].text = ""
	    })  
	    $('#btneventcustomer').on('Click',{
	    	Executions.sendRedirect("/eventcustomer.zul")
	    	alert("ยินดีต้อนรับ")
	    })
	    $('#btndatein').on('Click',{
	    	Executions.sendRedirect("/checkdate.zul")
	    	alert("ลงเวลาเข้าแล้ว")
	    })
	    $('#btndateout').on('Click',{
	    	Executions.sendRedirect("/checkdate.zul")
	    	alert("ลงเวลาออกแล้ว")
	    })
    }
}
