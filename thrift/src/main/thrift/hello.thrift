service HelloWorldService{
    void hello(1: string msg);
    string modify(1: HelloWorldRequest request);
}

struct HelloWorldRequest{
    1: required string name;
    2: optional i32 age;
    3: bool archive;
}