import { useState } from 'react';
import { Button, Form } from 'react-bootstrap';

import './SolarForm.css';

function SolarForm({ onSubmit }) {
  const [city, setCity] = useState(null);
  const [date, setDate] = useState(null);

  function submit(e) {
    e.preventDefault();

    const data = {
      city,
      date,
    };

    onSubmit(data);
  }

  return (
    <Form className="solarform">
      <Form.Group controlId="formBasicCity">
        <Form.Label>City</Form.Label>
        <Form.Control
          type="text"
          placeholder="Type city"
          onChange={(e) => setCity(e.target.value)}
        />
        <Form.Text className="text-muted">
        </Form.Text>
      </Form.Group>

      <Form.Group controlId="formBasicDate">
        <Form.Label>Password</Form.Label>
        <Form.Control type="date"
          onChange={(e) => setDate(e.target.value)} />
      </Form.Group>
      <Button className="formButton" variant="primary" type="submit" onClick={submit}>
        Submit
      </Button>
    </Form>
  );
}

export default SolarForm;
