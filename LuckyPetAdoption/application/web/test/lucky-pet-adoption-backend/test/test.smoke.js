test(
  'should return true when the server is listening on port ' + process.env.port,
  () => {
    expect(server.listen)
  }
)
