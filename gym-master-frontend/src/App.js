import React from 'react'
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import './index.css'
import Header from './Components/Header/Header';
import Footer from './Components/Footer/Footer';
import Body from './Components/Body/Body';
import {Routes,Route} from 'react-router-dom';
import Navigationbar  from './Components/Navigationbar';
import Login from './Components/Login/Login';
import Bmi from './Components/Bmi';
import Training from './Components/Training';
import Customer from './Components/Customer';
import Trainer from './Components/Trainer';
import CustomerAttendance from './Components/CustomerAttendance';
import TrainerAttendance from './Components/TrainerAttendance';
import Signup from './Components/Signup';
import Enquiry from './Components/Enquiry';
import Customertab from './Components/Customertab';
import UpdateCustomer from './Components/UpdateCustomer';
import Trainertab from './Components/Trainertab';
import Updatetrainer from './Components/Updatetrainer.js';
import Attendance from './Components/Attendance';

const App = () => {
return (
    <div>
    <Routes>
    <Route exact path = "/"  element = {<Body/>} />
    <Route exact path = "/footer"  element = {<Footer/>} />
    <Route exact path = "/login"  element = {<Login/>} />
    <Route exact path = "/bmi"  element = {<Bmi/>} />
    <Route exact path = "/training"  element = {<Training/>} />
    <Route exact path = "/customer" element = {<Customer/>} />
    <Route exact path = "/trainer" element = {<Trainer/>}/>
    <Route exact path = "/customeratt" element = {<CustomerAttendance/>}/>
    <Route exact path = "/traineratt" element = {<TrainerAttendance/>}/>
    <Route exact path = "/signup" element = {<Signup/>}/>
    <Route exact path = "/enquiry" element = {<Enquiry/>}/>
    <Route exact path = "/cttab" element = {<Customertab/>}/>
    <Route exact path = "/updatect" element = {<UpdateCustomer/>}/>
    <Route exact path = "/trainertab" element = {<Trainertab/>}/>
    <Route exact path = "/updatetr" element = {<Updatetrainer/>}/>
    <Route exact path = "/attendance" element = {<Attendance/>}/>
    <Route exact path = "/navigationbar" element = {<Navigationbar/>}/>
    </Routes>
    <Footer/>
    </div>
  )
}

export default App