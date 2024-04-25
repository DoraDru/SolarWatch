import React from 'react';
import { Table, Button } from 'react-bootstrap';

import './SolarInfo.css';

function SolarInfo({ info, goBack }) {
  return (
    <>
      <h1 className='cityName'>{info.city.name}</h1>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>Date</th>
            <th>Sunrise</th>
            <th>Sunset</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{info.date}</td>
            <td>{info.sunrise}</td>
            <td>{info.sunset}</td>
          </tr>
        </tbody>
      </Table>
      <Button className='backButton' variant='primary' type='submit' onClick={goBack}>Back</Button>
    </>
  );
}

export default SolarInfo;
