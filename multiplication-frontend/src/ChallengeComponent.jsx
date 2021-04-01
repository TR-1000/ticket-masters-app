import React from 'react';
import ApiClient from './ApiClient.js';

class ChallengeComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      a:'',
      b:'',
      username: '',
      answer: 0
    };
    this.handleSubmitResult = this.handleSubmitResult.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  componentDidMount(): void {
    ApiClient.challenge().then(
      res => {
        if(res.ok) {
          res.json().then(json =>{
            this.setState({
              a: json.factor_a,
              b: json.factor_b
            });
          });
        } else {
          this.updateMessage("Can't reach the server");
        }
      }
    );
  }


handleChange(e) {
  const name = e.target.name;
  this.setState({
    [name]: e.target.value
  });
}

handleSubmitResult(e) {
  e.preventDefault();
  ApiClient.sendAnswer(this.state.username, this.state.a, this.state.b, this.state.answer)
    .then(res => {

      if (res.ok) {
        res.json().then(json => {
          if (json.correct) {
            this.updateMessage(`Check out the big brain on ${this.state.username}! Your answer is Correct!`);

          } else {
            this.updateMessage("Sorry! That's inncorect. Try again.");
          }
        });
      } else {
        this.updateMessage("Error: server error or not available");
      }
    });
}

updateMessage(m: string) {
  this.setState({
    message: m
  });
}

render() {
  return (
    <div>
      <div>
        <h3>Your new challenge is</h3>
        <h1> {this.state.a} x {this.state.b} </h1>
      </div>
      <form onSubmit={this.handleSubmitResult}>
        <label> Your username:
          <input type="text" maxLength="12" name="username"value={this.state.username} onChange={this.handleChange}/>
          </label>
          <br/>
          <label> Your answer:
          <input type="number" min="0" name="answer" value={this.state.answer} onChange={this.handleChange}/>
          </label>
          <br/>
          <input type="submit" value="Submit"/>
      </form>
      <h4>{this.state.message}</h4>
    </div>
  )
}

}
export default ChallengeComponent;
