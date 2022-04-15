import React, { useEffect, useState } from 'react'
import{Form,Button} from 'react-bootstrap'
import axios  from 'axios';
import Navigationbar from './Navigationbar';

const Attendance = () => {
    const[attendance,setattendance] = useState([]);
  
    useEffect(() =>{
      axios.get("http://localhost:8080/allAttendance").then(response => {
        console.log(response)
        setattendance(response.data)
      })
  
    },[])
  return (
      <div>
        <Navigationbar/>
        <div className = "my-5">
     <h3 className = "text-center"> Attendance Management</h3>
     <br/>
     <div className ="container contact_div">
       <div className ="row">
         <div className ="col-md-6 col-10 mx-auto">
    <form class="row g-3">
    <div class="col-md-6">
   <h4>Customer Attendance</h4>
     </div>
     <div class="col-md-6">
    <Button style = {{backgroundColor:"white"}}>< a href ="/customeratt" className='btn-get-started'>Add</a></Button>
      </div>
      <br/>
      <br/>
      <br/>
      <div class="col-md-6">
   <h4>Trainer Attendance </h4>
     </div>
     <div class="col-md-6">
    <Button style = {{backgroundColor:"white"}}>< a href ="/traineratt" className='btn-get-started'>Add</a></Button>
      </div>
      <br/>
      <br/>
      <br/>
      <h4 className = "text-center"> Attendance List</h4>
      <table className="table table-striped table-bordered">
                  <thead>
                      <tr>
                          <th>Customer Id</th>
                          <th>Trainer Id</th>
                          <th>Date</th>
                          <th>Present</th>
                         </tr>
                  </thead>
                  <tbody>
                      {attendance.map(attendance =>
                          <tr key={attendance.id}>
                            <td>{attendance.customerId}</td>
                              <td>{attendance.trainerId}</td>
                              <td>{attendance.date}</td>
                              <td>{attendance.isPresent}</td>
                           
                              </tr>
                      )}
                  </tbody>
              </table>
    
   
  
    </form>
    </div>
    </div>
    </div>
         </div>
         </div>
  
    )
  }

export default Attendance
