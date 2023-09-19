import {BrowserRouter,Routes,Route} from 'react-router-dom'
import Login from './Pages/Login';
import SignUp from './Pages/SignUp';  
function App() {
  return (
    <>
    <BrowserRouter>
    <Routes>
      <Route exact path='/' element = {<Login/>}/>
      <Route exact path='/SignUp' element = {<SignUp/>}/>
    </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
