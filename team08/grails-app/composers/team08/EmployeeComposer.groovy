package team08

import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class EmployeeComposer extends GrailsComposer {

    def afterCompose = { window ->
        $('#listmanager > listitem > listcell').detach()
            def kk = Employee.findAll()
            $('#listmanager').append {
                for(c in kk) {
                    def s = TimeWork.findByEmployee(c)
                    listitem(value: c) {
                        listcell(label: c.idem)
                        listcell(label: c.nameem)
                        listcell(label: c.lnameem)
                        listcell(label: s.timein)
                        listcell(label: s.timeout)
                        listcell(label: c.statusem)
                        listcell(label: c.classem)
                    }
                    
                }
            }


        $('#listmanager').on('select',{
            $('#btnnext').setDisabled(false)
            $('#btndelete').setDisabled(false)
            def xs = $(it).val()
                
            $('#btndelete').on('click',{
                
                xs.delete()
                
                alert("ลบเสร็จสิ้น")
                     
                   
            })
            $('#btnnext').on('click',{
                $('#fname1').setValue(xs.nameem)
                $('#lname1').setValue(xs.lnameem)
                $('#nickname1').setValue(xs.nickname)
                $('#sex1').setValue(xs.sexem)
                $('#born1').setValue(xs.birthday)
                $('#age1').setValue(xs.ageem)
                $('#irreligi1').setValue(xs.irreligious)
                $('#nationality1').setValue(xs.nation)
                $('#idCityzen1').setValue(xs.idppem)
                $('#addressh').setValue(xs.address)
                $('#addressh1').setValue(xs.subdistrict)
                $('#addressh2').setValue(xs.district)
                $('#addressh3').setValue(xs.province)
                $('#addressh4').setValue(xs.nprovince)
                $('#tel1').setValue(xs.tel)
                $('#class1').setValue(xs.classem)
                $('#idem1').setValue(xs.idem)

                $('#listmanager').setVisible(false)
                $('#managerpage1').setVisible(false)
                $('#history').setVisible(true)      
                   
            })

        })
        

        $('#btnrefresh').on('click',{
            $('#listmanager > listitem > listcell').detach()
            def j = Employee.findAll()
            $('#listmanager').append {
                for(c in j) {
                    def s = TimeWork.findByEmployee(c)
                    listitem(value: c) {
                        listcell(label: c.idem)
                        listcell(label: c.nameem)
                        listcell(label: c.lnameem)
                        listcell(label: s.timein)
                        listcell(label: s.timeout)
                        listcell(label: c.statusem)
                        listcell(label: c.classem)
                    }
                    
                }
            }
            })
        $('#btnplus').on('click',{
            $('#listmanager').setVisible(false)
            $('#managerpage1').setVisible(false)
            $('#normal').setVisible(true)
            
            })
        $('#btnback1').on('click',{
            $('#listmanager').setVisible(true)
            $('#managerpage1').setVisible(true)
            $('#normal').setVisible(false)
            

            })
        $('#btnplus1').on('click',{
            def aa = $('#fname')[0].text
            def aa1 = $('#lname')[0].text
            def aa2 = $('#nickname')[0].text
            def aa3 = $('#sex')[0].text
            def aa4 = $('#born')[0].text
            def aa5 = $('#age')[0].text
            def aa6 = $('#irreligi')[0].text
            def aa7 = $('#nationality')[0].text
            def aa8 = $('#idCityzen')[0].text
            def aa9 = $('#address')[0].text
            def aa10 = $('#address1')[0].text
            def aa11 = $('#address2')[0].text
            def aa12 = $('#address3')[0].text
            def aa13 = $('#address4')[0].text
            def aa14 = $('#tel')[0].text
            def aa15 = $('#class')[0].text
            def aa16 = $('#idem')[0].text

            if(aa.size()==0||aa1.size()==0||aa2.size()==0||aa3.size()==0||aa4.size()==0||aa5.size()==0||aa6.size()==0||aa7.size()==0||aa10.size()==0||aa9.size()==0||aa8.size()!=13||aa11.size()==0||aa12.size()==0||aa13.size()==0||aa14.size()==0||aa15.size()==0||aa16.size()==0){
                alert("กรุณากรอกให้ครบถ้วนและถูกต้อง")
           
            }else {
                def b = new Employee(
                    nameem: aa,
                    classem:aa15,
                    idem:aa16,
                    statusem:"อยู่",
                    lnameem:aa1,
                    tel:aa14,
                    address:"Home",
                    numaddress:aa9,
                    district:aa11,
                    subdistrict:aa10,
                    province:aa12,
                    nprovince:aa13,
                    idppem:aa8,
                    ageem:aa5,
                    passem:"1",
                    nickname:aa2,
                    birthday:aa4,
                    sexem:aa3,
                    nation:aa7,
                    irreligious:aa6
                    )
                    b.save()

            
            def borrowday = new Date()
            def g = borrowday.format("hh:mm a")
            def c = new TimeWork(employee:b,timein:g,timeout:"-")
            c.save()


            alert("complete")
            $('#listmanager').setVisible(true)
            $('#managerpage1').setVisible(true)
            $('#normal').setVisible(false)
            }

            })
        
        $('#btnback2').on('click',{
            $('#listmanager').setVisible(true)
            $('#managerpage1').setVisible(true)
            $('#history').setVisible(false)
            

            })


        
        $('#btnback').on('click',{
            Executions.sendRedirect("/index.zul")
            

            })



        


    }
}