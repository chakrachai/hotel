package team08

import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class CheckInHotelComposer extends GrailsComposer {

    def afterCompose = { window ->
        def searchData = DataSignIn.get(2)
        String employeedata
        def datacustomer
        def customer

        if (searchData.datainput==null || searchData.datainput==""){
            Executions.sendRedirect("/index.zul")
        }else{
        searchData = DataSignIn.get(2)
        alert(searchData.datainput)
        employeedata = searchData.datainput
        searchData.datainput = ""
        searchData.save()
        $('#employeeid')[0].text = employeedata
        }

//=================================================checkdata==============================================================================
   	$('#searchCustomer').on('click',{
    		datacustomer = $('#customerId')[0].text
    		customer = MemberCustomer.findByMemberId(datacustomer)
    		if(customer == null){
    			alert("ไม่พบข้อมูล")
    		}else{
    			$('#customerName')[0].text=customer.fName
				$('#customerLastname')[0].text=customer.lName    			
				$('#passport')[0].text=customer.idCityzen

                $('#searchCustomer').setVisible(false)
    		}
    	})
//==================================================find and show dataCustomer==========================================================
    $('#checkin').on('click',{
        def checkindata = new Room(
            roomNo : $('#room')[0].text,
            roomflore : $('#classRoom')[0].text,
            dayIn : $('#dayin')[0].text,
            dayOut : $('#dayout')[0].text,
            roomStatus: "ใช้งาน",
            customer:MemberCustomer.findByMemberId(datacustomer),
            employee:Employee.findByIdem(employeedata)
        ).save()
        $('#searchCustomer').setVisible(true)
    })
//==================================================================checkinbutton===========================================================
        $('#outroom').on('click',{
        def checkindata = new Room(
            roomNo : $('#room')[0].text,
            roomflore : $('#classRoom')[0].text,
            dayIn : $('#dayin')[0].text,
            dayOut : $('#dayout')[0].text,
            roomStatus: "ห้องชำรุด",
            customermany:$('#customerMany').text,
            customer:MemberCustomer.findByMemberId(datacustomer),
            employee:Employee.findByIdem(employeedata)
        ).save()
        $('#searchCustomer').setVisible(true)
    })
//=================================================================ปุ่มแจ้งซ้อม==============================================================
        $('#clearbtn').on('click',{
            $('#room')[0].text =""
            $('#classRoom')[0].text =""
            $('#dayin')[0].text =""
            $('#dayout')[0].text =""
            $('#customerName')[0].text =""
            $('#customerLastname')[0].text =""
            $('#passport')[0].text =""
            $('#customerMany')[0].text =""
            $('#customerId')[0].text =""
            $('#searchCustomer').setVisible(true)
        })
//====================================================================clearbutton============================================================
    }
}
