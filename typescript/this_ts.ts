const user = {
    id: 123,
   //admin: false,
    becomeAdmin: function () {
      console.log("Admin ",this.admin);
    },
  };
  user.becomeAdmin();
  console.log("User ",user);