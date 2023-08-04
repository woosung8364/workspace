import axios from 'axios';
import './App.css';
import { useEffect, useState } from 'react';
import { Stack , Button} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

function BootstrapApp() {


  return (
    <div>
      <Stack direction="horizontal" gap={10}>
        <Button as="a" variant="primary">
          Button as link
        </Button>
        <Button as="a" variant="success">
          Button as link
        </Button>
      </Stack>;
    </div>


  );
}

export default BootstrapApp;
