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
        def customernamedata =""
        if (searchData.datainput==null || searchData.datainput==""){
            Executions.sendRedirect("/index.zul")
        }
        else{
            searchData = DataSignIn.get(2)
            alert("ยินดีต้อนรับ")
            employeedata = searchData.datainput
            $('#employeeid').setDisabled(true)
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
                $('#customerName').setDisabled(true)
                $('#customerLastname').setDisabled(true)
                $('#passport').setDisabled(true)
                $('#customerId').setDisabled(true)
    		}
    	})

//==================================================find and show dataCustomer==========================================================
    $('#checkin').on('click',{
        if(datacustomer=="" | datacustomer==null){
         alert("ไม่มีข้อมูลลูกค้า")           
         }else{
            def checkindata = new Room(
            roomNo : $('#room')[0].text,
            roomflore : $('#classRoom')[0].text,
            dayIn : $('#dayin')[0].text,
            dayOut : $('#dayout')[0].text,
            roomStatus: "ใช้งาน",
            customermany:$('#customerMany')[0].text,
            customer:MemberCustomer.findByMemberId(datacustomer),
            employee:Employee.findByIdem(employeedata)
        ).save()
        $('#searchCustomer').setVisible(true)
        alert("save ห้องพักถูกใช้งาน")
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
            $('#customerName').setDisabled(true)
            $('#customerLastname').setDisabled(false)
            $('#passport').setDisabled(false)
            $('#customerId').setDisabled(false)
    if($('#roomList')!=null)
            $('#roomList > listitem').detach()
    for (dataroom in Room.findAll()){         

        if(dataroom.customerId == null){
            customernamedata=employeedata
        }else{
            customernamedata = dataroom.customer.fName+""
        }

        if(dataroom.roomStatus!="ว่าง"){
            $('#roomList').append { 
                listitem(value:dataroom){
                    listcell{   
                        label(value:dataroom.roomflore)
                    }
                    listcell{   
                        label(value:dataroom.roomNo)
                    }
                    listcell{   
                        label(value:customernamedata)
                    }
                    listcell{   
                        label(value:dataroom.dayIn)
                    }
                    listcell{   
                        label(value:dataroom.dayOut)
                    }
                    listcell{   
                        label(value:dataroom.roomStatus)
                    }

                }
            }
        }

    }

    }
})
//==================================================================checkinbutton===========================================================
        $('#outroom').on('click',{
        if($('#roomList')!=null)
            $('#roomList > listitem').detach()
        def checkindata = new Room(
            roomNo : $('#room')[0].text,
            roomflore : $('#classRoom')[0].text,
            dayIn : $('#dayin')[0].text,
            dayOut : $('#dayout')[0].text,
            roomStatus: "ห้องชำรุด",
            employee:Employee.findByIdem(employeedata)
        ).save()
        $('#searchCustomer').setVisible(true)
            $('#room')[0].text =""
            $('#classRoom')[0].text =""
            $('#dayin')[0].text =""
            $('#dayout')[0].text =""
            $('#customerName')[0].text =""
            $('#customerLastname')[0].text =""
            $('#passport')[0].text =""
            $('#customerMany')[0].text =""
            $('#customerId')[0].text =""
            $('#customerLastname').setDisabled(false)
            $('#passport').setDisabled(false)
            $('#customerId').setDisabled(false)
            alert ("Save ห้องชำรุด")
    
        for (dataroom in Room.findAll()){                   
            $('#roomList').append {
                if(dataroom.customerId == null){
                    customernamedata=employeedata
                }
                else{
                    customernamedata = dataroom.customer.fName+""
                }
                if(dataroom.roomStatus!="ว่าง"){
                    listitem(value:dataroom){
                        listcell{   
                            label(value:dataroom.roomflore)
                        }
                        listcell{   
                            label(value:dataroom.roomNo)
                        }
                        listcell{   
                            label(value:customernamedata)
                        }
                        listcell{   
                            label(value:dataroom.dayIn)
                        }
                        listcell{   
                            label(value:dataroom.dayOut)
                        }
                        listcell{   
                            label(value:dataroom.roomStatus+"  ")
                        }

                    }
                }
            }   
        }     
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
            $('#customerLastname').setDisabled(false)
            $('#passport').setDisabled(false)
            $('#customerId').setDisabled(false)
        })
//====================================================================clearbutton============================================================   
       $('#reloadbtn').on('click',{
       if($('#roomList')!=null)
            $('#roomList > listitem').detach()

        
        for (dataroom in Room.findAll()){                   
            $('#roomList').append {
                if(dataroom.customerId == null){
                    customernamedata=employeedata
                }
                else{
                    customernamedata = dataroom.customer.fName+""
                }

                if(dataroom.roomStatus!="ว่าง"){
                    listitem(value:dataroom){
                        listcell{   
                            label(value:dataroom.roomflore)
                        }
                        listcell{   
                            label(value:dataroom.roomNo)
                        }
                        listcell{   
                            label(value:customernamedata)
                        }
                        listcell{   
                            label(value:dataroom.dayIn)
                        }
                        listcell{   
                            label(value:dataroom.dayOut)
                        }
                        listcell{   
                            label(value:dataroom.roomStatus+"  ")
                        }
                }
               }
            }
        }
        })
//==============================================================================reloaddata=========================================================

        $('#roomList').on('select',{
            def roomselect = $(it).getSelectedItem().getValue()
            $('#roomList > listitem').detach()

        for (dataroom in Room.findAll()){                   
            $('#roomList').append {
                if(dataroom.customerId == null){
                    customernamedata=employeedata
                }
                else{
                    customernamedata = dataroom.customer.fName+""
                }

                if(dataroom.roomStatus!="ว่าง"){
                   if(roomselect.id == dataroom.id){
                    listitem(value:dataroom){
                        listcell{   
                            label(value:dataroom.roomflore)
                        }
                        listcell{   
                            label(value:dataroom.roomNo)
                        }
                        listcell{   
                            label(value:customernamedata)
                        }
                        listcell{   
                            label(value:dataroom.dayIn)
                        }
                        listcell{   
                            label(value:dataroom.dayOut)
                        }
                        listcell{   
                            label(value:dataroom.roomStatus+"  ")
                            button(label:"กลับสู่สถานะว่าง")
                        }

                    }
                }else{
                     listitem(value:dataroom){
                    listcell{   
                        label(value:dataroom.roomflore)
                    }
                    listcell{   
                        label(value:dataroom.roomNo)
                    }
                    listcell{   
                        label(value:customernamedata)
                    }
                    listcell{   
                        label(value:dataroom.dayIn)
                    }
                    listcell{   
                        label(value:dataroom.dayOut)
                    }
                    listcell{   
                        label(value:dataroom.roomStatus)
                    }

                } 
             
                }
               }
            }
        }
//============================================================================roomselect==========================================================
        $('#roomList > listitem > listcell > button[label="กลับสู่สถานะว่าง"]').on('click',{
            roomselect.roomStatus = "ว่าง"
            roomselect.save()
            alert("กลับสู่สถานะว่าง")
            $('#roomList > listitem').detach()
            for (dataroom in Room.findAll()){                   
            $('#roomList').append {
                if(dataroom.customerId == null){
                    customernamedata=employeedata
                }else{
                    customernamedata = dataroom.customer.fName+""
                }
                if(dataroom.roomStatus!="ว่าง"){
                    listitem(value:dataroom){
                    listcell{   
                        label(value:dataroom.roomflore)
                    }
                    listcell{   
                        label(value:dataroom.roomNo)
                    }
                    listcell{   
                        label(value:customernamedata)
                    }
                    listcell{   
                        label(value:dataroom.dayIn)
                    }
                    listcell{   
                        label(value:dataroom.dayOut)
                    }
                    listcell{   
                        label(value:dataroom.roomStatus)
                    }

                }
                }
            }
        }
        })
        })
//=============================================================================disabled="true"======clerRoom======================================================
        $('#searchdatabtn').on('click',{
            if($('#tsearch')[0].text+"" == null || $('#tsearch')[0].text+"" == ""){
                alert("กรุณาตรวจสอบข้อมูล")
            }else{
                int i=0
            if($('#searchstatus')[0].text+"" == "จาก"){
                alert("กรุณาเลือกรูปแบบการค้นหา")
            }else if($('#searchstatus')[0].text+"" == "ชั้น"){
                if($('#roomList')!=null)
                    $('#roomList > listitem').detach()
                for (dataroom in Room.findAllByRoomflore($('#tsearch')[0].text+"")){                   
                    $('#roomList').append {
                        if(dataroom.customerId == null){
                            customernamedata=employeedata
                        }
                        else{
                            customernamedata = dataroom.customer.fName+""
                        }
                        if(dataroom.roomStatus!="ว่าง"){
                            i++
                            listitem(value:dataroom){
                                listcell{   
                                    label(value:dataroom.roomflore)
                                }
                                listcell{   
                                    label(value:dataroom.roomNo)
                                }
                                listcell{   
                                    label(value:customernamedata)
                                }
                                listcell{   
                                    label(value:dataroom.dayIn)
                                }
                                listcell{   
                                    label(value:dataroom.dayOut)
                                }
                                listcell{   
                                    label(value:dataroom.roomStatus+"  ")
                                }
                        }
                       }
                    }
                }
                alert("พบข้อมูล "+i+" จำนวน")
                i=0
            }else if($('#searchstatus')[0].text+"" == "สถานะ"){
               if($('#roomList')!=null)
                    $('#roomList > listitem').detach()
                for (dataroom in Room.findAllByRoomStatus($('#tsearch')[0].text+"")){                   
                    $('#roomList').append {
                        if(dataroom.customerId == null){
                            customernamedata=employeedata
                        }
                        else{
                            customernamedata = dataroom.customer.fName+""
                        }
                        if(dataroom.roomStatus!="ว่าง"){
                            i++
                            listitem(value:dataroom){
                                listcell{   
                                    label(value:dataroom.roomflore)
                                }
                                listcell{   
                                    label(value:dataroom.roomNo)
                                }
                                listcell{   
                                    label(value:customernamedata)
                                }
                                listcell{   
                                    label(value:dataroom.dayIn)
                                }
                                listcell{   
                                    label(value:dataroom.dayOut)
                                }
                                listcell{   
                                    label(value:dataroom.roomStatus+"  ")
                                }
                        }
                       }
                    }
                }
                alert("พบข้อมูล "+i+" จำนวน")
                i=0
            }else if($('#searchstatus')[0].text+"" == "เลขห้อง"){
               if($('#roomList')!=null)
                    $('#roomList > listitem').detach()
                for (dataroom in Room.findAllByRoomNo($('#tsearch')[0].text+"")){                   
                    $('#roomList').append {
                        if(dataroom.customerId == null){
                            customernamedata=employeedata
                        }
                        else{
                            customernamedata = dataroom.customer.fName+""
                        }
                        if(dataroom.roomStatus!="ว่าง"){
                            i++
                            listitem(value:dataroom){
                                listcell{   
                                    label(value:dataroom.roomflore)
                                }
                                listcell{   
                                    label(value:dataroom.roomNo)
                                }
                                listcell{   
                                    label(value:customernamedata)
                                }
                                listcell{   
                                    label(value:dataroom.dayIn)
                                }
                                listcell{   
                                    label(value:dataroom.dayOut)
                                }
                                listcell{   
                                    label(value:dataroom.roomStatus+"  ")
                                }
                        }
                       }
                    }
                }
                alert("พบข้อมูล "+i+" จำนวน")
                i=0
            }else {
                alert("Error...")
            }
            }
        })
//======================================================================================searchroom=================================================================
        $('#clearsearchdatabtn').on('click',{
            $('#searchstatus')[0].text = "จาก"
            $('#tsearch')[0].text = ""
        })
//========================================================================================clearsearchroom==========================================================
        $('#btnsingout').on('click',{
            searchData.datainput = ""
            searchData.save()
            Executions.sendRedirect("/index.zul")
        })
    }
}