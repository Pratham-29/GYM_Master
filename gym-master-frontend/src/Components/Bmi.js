import React from 'react'
import { useEffect,useState } from 'react'
import Navigationbar from './Navigationbar';

const Bmi = () => {
    const[height,setHeight] = useState(0);
    const[weight,setWeight] = useState(0);
    const[bmi,setBMI] = useState(0);

    function handleHeight(e){
        let h = e.target.value;
        setHeight(h);
    }

    function handleWeight(e){
        let w = e.target.value;
        setWeight(w);
    }

    //handling calculations
    useEffect(() => {
        let bmi1 = (weight/(height*2))*100;
        setBMI(bmi1.toFixed(2));
    },[height,weight]);

  return (
    <div>
      <Navigationbar/>
    
    
    <div className = "App" style={{color:"grey"}}>
         <div className = "my-5">
     <h2 className = "text-center"> BMI Calculator </h2>
     <div className ="container contact_div">
       <div className ="row">
         <div className ="col-md-6 col-10 mx-auto">
        <p>Height (cm)</p><input type = "number" onChange={handleHeight} placeholder = "Enter height"></input>
        <br/>
        <p>Weight (kg)</p><input type = "number" onChange={handleWeight} placeholder = "Enter weight"></input>
        <br/>
        <br/>
        <h2>BMI : {bmi}</h2>
      
    </div>
    </div>
</div>
</div>
    </div>
    </div>
  );
}

export default Bmi
