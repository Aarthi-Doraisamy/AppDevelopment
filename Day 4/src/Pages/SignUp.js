import React, { useState } from 'react';
import '../Asserts/Css/SignUp.css';

function LibrarySignUp() {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    libraryCardNumber: '',
    address: '',
    phoneNumber: '',
  });

  const [validationError, setValidationError] = useState('');

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Validate password format (must have at least 8 characters)
    if (formData.password.length < 8) {
      setValidationError('Password must have at least 8 characters');
      return;
    }

    // Validate library card number (must be numeric)
    if (!/^\d+$/.test(formData.libraryCardNumber)) {
      setValidationError('Library Card Number must be numeric');
      return;
    }

    // Validate phone number (must be a 10-digit number)
    if (!/^\d{10}$/.test(formData.phoneNumber)) {
      setValidationError('Phone Number must be a 10-digit number');
      return;
    }

    // If all validations pass, you can proceed with sending the data to the backend
    // Add your API call logic here

    // Clear any previous validation errors
    setValidationError('');
  };

  return (
    <div>
      <h2>Library Sign Up</h2>
      {validationError && <p className="error-message">{validationError}</p>}
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="firstName">First Name</label>
          <input
            type="text"
            id="firstName"
            name="firstName"
            value={formData.firstName}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="lastName">Last Name</label>
          <input
            type="text"
            id="lastName"
            name="lastName"
            value={formData.lastName}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="libraryCardNumber">Library Card Number</label>
          <input
            type="text"
            id="libraryCardNumber"
            name="libraryCardNumber"
            value={formData.libraryCardNumber}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="address">Address</label>
          <input
            type="text"
            id="address"
            name="address"
            value={formData.address}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="phoneNumber">Phone Number</label>
          <input
            type="tel"
            id="phoneNumber"
            name="phoneNumber"
            value={formData.phoneNumber}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit" className="button">Submit</button>
      </form>
    </div>
  );
}

export default LibrarySignUp;
