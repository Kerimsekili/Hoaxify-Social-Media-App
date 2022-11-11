import React from "react";
import { singup } from "../api/apiCalls";

class UserSignupPage extends React.Component {
  state = {
    username: null,
    nickname: null,
    password: null,
    passwordRepeat: null,
    pendingApiCall: false,
  };

  onChange = (event) => {
    const { name, value } = event.target;
    this.setState({
      [name]: value,
    });
  };

  onClickSignup = async (event) => {
    event.preventDefault();

    const { username, nickname, password } = this.state;

    const body = {
      username,
      nickname,
      password,
    };

    this.setState({ pendingApiCall: true });

    try {
      const response = await singup(body);
    } catch (error) {}

    this.setState({ pendingApiCall: false });

    // singup(body)
    //   .then((response) => {
    //     this.setState({ pendingApiCall: false });
    //   })
    //   .catch((error) => {
    //     this.setState({ pendingApiCall: false });
    //   });
  };

  render() {
    const { pendingApiCall } = this.state;
    return (
      <div className="container">
        <form>
          <h1 className="text-center">Sign Up</h1>
          <div className="mb-3">
            <label>Username</label>
            <input
              className="form-control"
              name="username"
              onChange={this.onChange}
            />
          </div>
          <div className="mb-3">
            <label>Nickname</label>
            <input
              className="form-control"
              name="nickname"
              onChange={this.onChange}
            />
          </div>
          <div className="mb-3">
            <label>Password</label>
            <input
              className="form-control"
              name="password"
              type={"password"}
              onChange={this.onChange}
            />
          </div>
          <div className="mb-3">
            <label>Password Repeat</label>
            <input
              className="form-control"
              name="passwordRepeat"
              type={"password"}
              onChange={this.onChange}
            />
          </div>
          <div className="text-center">
            <button
              className="btn btn-primary"
              onClick={this.onClickSignup}
              disabled={pendingApiCall}
            >
              {pendingApiCall && (
                <span className="spinner-border spinner-border-sm"></span>
              )}
              Sign Up
            </button>
          </div>
        </form>
      </div>
    );
  }
}
export default UserSignupPage;
