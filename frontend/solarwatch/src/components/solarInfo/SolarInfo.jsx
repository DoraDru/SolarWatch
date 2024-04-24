import { useState } from 'react';
import SolarForm from '../SolarForm/SolarForm';
import './SolarInfo.css';

async function fetchData(data) {
  let url = `/api/solarwatch?city=${data.city}`;

  if (data.date !== null) {
    url += `&date=${data.date}`;
  }

  const response = await fetch(url);
  return response;
}

function SolarInfo() {

  const [solarInfo, setSolarInfo] = useState();

  async function fetchSolarInfo(data) {
    try {
      const response = await fetchData(data);

      if (response.ok) {
        const result = await response.json();
        setSolarInfo(result);
      } else if (response.status === 400) throw new Error('400, Bad request');
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <div className="solar-container">
      <SolarForm onSubmit={fetchSolarInfo} />
    </div>
  );
}

export default SolarInfo;
