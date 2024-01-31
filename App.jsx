import axios from 'axios';
import React, { useEffect, useState } from 'react';

function App() {
    const [callstate, setCallstate] = useState("fail");
    const [studentsdata, setStudentsData] = useState([]);
    const [student, setStudent] = useState({
        "item_id": "",
        "name": "",
        "date": "",
        "price": ""
    });

    useEffect(() => {
        const fetchdata = async () => {
            try {
                const response = await axios.get('http://localhost:8080/hotel/allitems');
                setStudentsData(response.data);
            } catch (error) {
                console.error('Error fetching data:', error.message);
            }
        };
        fetchdata();
    }, [callstate]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setStudent({
            ...student,
            [name]: value
        });
    };

    const createStudent = async (e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/hotel/additem', student);
            setCallstate("success");
        } catch (error) {
            console.error('Error creating user:', error.message);
            setCallstate("fail");
        }
    };
    const deleteStudent = async (id) => {
      try {
          await axios.delete(http://localhost:8080/hotel/delete/${id});
          setCallstate("success");//http://localhost:8080/hotel/delete/3
      } catch (error) {
          console.error('Error deleting item:', error.message);
          setCallstate("fail");
      }
  };

    const updateStudent = async (e) => {
        e.preventDefault();
        try {
            await axios.put(http://localhost:8080/hotel/updateitem/${student.item_id}, student);
            setCallstate("success");
        } catch (error) {
            console.error('Error updating user:', error.message);
            setCallstate("fail");
        }
    };

    return (
        <div>
            <form>
                Item ID: <input type="text" name="item_id" value={student.item_id} onChange={handleChange} />
                <br />
                Name: <input type="text" name="name" value={student.name} onChange={handleChange} />
                <br />
                Date: <input type="text" name="date" value={student.date} onChange={handleChange} />
                <br />
                Price: <input type="text" name="price" value={student.price} onChange={handleChange} />
                <br />
                <button onClick={createStudent}>Create Item</button>
                <button onClick={updateStudent}>Update Item</button>
                <button onClick={deleteStudent}>Delete Item</button>
            </form>
            {studentsdata.map(item => (
                <div className='container' key={item.item_id}>
                    <p>{item.name}</p>
                    <button className='btn' onClick={() => deleteStudent(item.item_id)}>Delete</button>
                </div>
            ))}
        </div>
    );
}

export default App;