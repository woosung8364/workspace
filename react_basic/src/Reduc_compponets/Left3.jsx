import {useSelector } from "react-redux/es/hooks/useSelector";

function Left3(props){

  console.log(3);
  const number = useSelector((state)=> state.number);
  return (
    <div>
      <h1>left3 : {number}</h1>
    </div>
  )
}

export default Left3;