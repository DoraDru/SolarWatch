import { useState } from 'react';
import SolarForm from '../../components/solarForm/SolarForm';
import { Alert } from 'react-bootstrap';
import './SolarPage.css';
import SolarInfo from '../../components/solarInfo/SolarInfo';

async function fetchData(data) {
  let url = `/api/solarwatch?city=${data.city}`;

  if (data.date !== null) {
    url += `&date=${data.date}`;
  }

  const response = await fetch(url);
  return response;
}

function SolarPage() {
  const [solarInfo, setSolarInfo] = useState();
  const [isDisplay, setIsDisplay] = useState(false);
  const [show, setShow] = useState(false);
  const [alertMessage, setAlertMessage] = useState();

  async function fetchSolarInfo(data) {
    try {
      const response = await fetchData(data);

      if (response.ok) {
        const result = await response.json();
        setSolarInfo(result);
        setShow(false);
        setIsDisplay(true);
      } else if (response.status === 400) throw new Error('Please provide a valid city name.');
    } catch (error) {
      setAlertMessage(error.message);
      setShow(true);
    }
  }

  function back() {
    setIsDisplay(false);
  }

  return (
    <div className='solar-container'>
      <Alert className='alert' show={show} variant='danger'>
        {alertMessage}
      </Alert>
      {isDisplay ?
        solarInfo ?
          <SolarInfo info={solarInfo} goBack={back} /> :
          <div>load</div> :
        <SolarForm onSubmit={fetchSolarInfo} />}

    </div>
  );
}

export default SolarPage;
