import { useState } from "react"
import SolarForm from "../SolarForm/SolarForm"
import "./SolarInfo.css"

async function fetchData(data){
  let url = `/api/solarwatch?city=${data.city}`;
  
  if (data.date !== null) {
    url+= `&date=${data.date}`
  }

  console.log(url)
  let response = await fetch(url);
  let result = response.json();
  return result;
}

function SolarInfo() {

  const [solarInfo, setSolarInfo] = useState();

  async function fetchSolarInfo(data){
    let result = await fetchData(data);
    console.log(result);
  }

  return (
    <div className="solar-container">
      <SolarForm onSubmit={fetchSolarInfo}/>
    </div>
  )
}

export default SolarInfo