class ApiClient {
  static SERVER_URL = 'http://localhost:8080';
  static GET_CHALLENGE = '/challenges/random';
  static POST_RESULT = '/attempts';

  static challenge(): Promise<Response> {
    return fetch(ApiClient.SERVER_URL + ApiClient.GET_CHALLENGE);
  }

  static sendAnswer(user: string, a: number, b:number, answer: number): Promise <Response> {
    console.log(user);
    console.log(answer);
    return fetch (ApiClient.SERVER_URL + ApiClient.POST_RESULT, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      }, body: JSON.stringify(
            {
              username: user,
              factor_a: a,
              factor_b: b,
              answer: answer
            }
          )
    });
  }
}

export default ApiClient;
