 $(function () {
 var dialog=new Vue({
     el:"#myDialog",
     data() {
              return {
                dialogVisible: false,
                form: {
                          username: '',
                          region: '',
                          date1: '',
                          date2: '',
                          delivery: false,
                          type: [],
                          resource: '',
                          desc: '',
                          email:'',
                          password:''
                        }
              };
            },
            methods: {
              handleClose(done) {
                this.$confirm('确认关闭？')
                  .then(_ => {
                    done();
                  })
                  .catch(_ => {});
              },
               onSubmit() {
                      $.ajax({
                                  url: APP_PATH+"/register",
                                  type: "POST",
                                  data: JSON.stringify(this.form),
                                  contentType: "application/json; charset=utf-8",
                                  dataType: "json",
                                  success: function (data, textStatus, jqXHR) {
                                          alert(data.message);
                                  },
                                  error: function (jqXHR, textStatus, errorThrown) {

                                  alert('fail'+jqXHR.status);
                          /*            if (jqXHR.status === 401) {
                                          $('#loginErrorModal')
                                              .modal("show")
                                              .find(".modal-body")
                                              .empty()
                                              .html("<p>Spring exception:<br>" + jqXHR.responseJSON.exception + "</p>");
                                      } else {
                                          throw new Error("an unexpected error occured: " + errorThrown);
                                      }*/
                                  }
                              });

                    }
            }
    });
    });