package team08

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class EmployeeComposer extends GrailsComposer {

    def afterCompose = { window ->
        
        $('#btnrefresh').on('click',{
            $('#listmanager > listitem > listcell').detach()
            	def yer = Employee.findAll()
            for(loops in yer){
                
                        $('#listmanager').append {
                        listitem(value:loops){
                            listcell{   
                                label(value:loops.idem)
                            }
                            listcell{
                                label(value:loops.nameem)                       
                            }
                            listcell{
                                label(value:loops.lnameem)                       
                            }
                            listcell{
                                label(value:loops.tel)                       
                            }
                            listcell{
                                label(value:loops.ageem)                       
                            }
                            listcell{
                                label(value:loops.statusem)                       
                            }
                            listcell{
                                label(value:loops.classem)                       
                            }
                        }

                    }
                }

            

            })
        $('#btnplus').on('click',{
            $('#managerpage').setVisible(false)
            $('#normal').setVisible(true)
            
            })
        $('#btnback1').on('click',{
            $('#managerpage').setVisible(true)
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
        	alert("complete")
            $('#managerpage').setVisible(true)
            $('#normal').setVisible(false)
            

            })
        $('#btnnext').on('click',{
            $('#managerpage').setVisible(false)
            $('#history').setVisible(true)
            

            })
        $('#btnback2').on('click',{
            $('#managerpage').setVisible(true)
            $('#history').setVisible(false)
            

            })


    }
}