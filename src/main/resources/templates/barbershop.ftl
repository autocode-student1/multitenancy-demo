<!DOCTYPE html>

<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Barbershop Demo</title>
  <link rel="stylesheet" type="text/css" href="/css/materialize.min.css"/>
  <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>

<body>
<div class="container">
  <div class="row">
    <div class="col s12 m12">
      <div class="card">
        <div class="card-content center-align">
          <img src="/img/icon.png" alt="" width="180">
          <h6 class="grey-text text-darken-4">Unleash The Beast</h6>
        </div>
        <div class="card-action">
          <form method="post" action="/barbershop">
            <div class="row">
              <div class="col s1 m1 l2"></div>
              <div class="form-label col s4 m4 l3">
                <label for="barberId">Barber</label>
              </div>
              <div class="input-field col s6 m6 l5">
                <select id="barberId" name="barberId">
                  <option value="" disabled selected></option>
                  <#list barbers as barber>
                    <option value="${barber.id}">${barber.name}</option>
                  </#list>
                </select>
              </div>
              <div class="col s1 m1 l2"></div>
            </div>
            <div class="row">
              <div class="col s1 m1 l2"></div>
              <div class="form-label col s4 m4 l3">
                <label for="timeSlot">Time Slot</label>
              </div>
              <div class="input-field col s6 m6 l5">
                <select id="timeSlot" name="timeSlot">
                  <option value="" disabled selected></option>
                  <#list timeSlots as timeSlot>
                    <option value="${timeSlot}">${timeSlot}</option>
                  </#list>
                </select>
              </div>
              <div class="col s1 m1 l2"></div>
            </div>
            <div class="row">
              <div class="col s1 m1 l2"></div>
              <div class="form-label col s4 m4 l3">
                <label for="clientName">Name</label>
              </div>
              <div class="input-field col s6 m6 l5">
                <input placeholder="Enter your name" id="clientName" name="clientName" type="text">
              </div>
              <div class="col s1 m1 l2"></div>
            </div>
            <div class="row">
              <div class="col s1 m1 l2"></div>
              <div class="form-label col s4 m4 l3">
                <label for="clientPhone">Phone</label>
              </div>
              <div class="input-field col s6 m6 l5">
                <input placeholder="Enter your phone number" id="clientPhone" name="clientPhone"
                       type="text">
              </div>
              <div class="col s1 m1 l2"></div>
            </div>
            <div class="row">
              <div class="col s1 m4 l5"></div>
              <div class="col s10 m4 l2 center">
                <button class="btn-large waves-effect waves-light" type="submit" name="action">Book
                </button>
              </div>
              <div class="col s1 m4 l5"></div>
            </div>
            <input type="hidden" name="tenantId" value="${tenantId}"/>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="row center footer">
    <p>Created by John Smith <a href="mailto:john.smith@acme.com">john.smith@acme.com</a></p>
  </div>
</div>

<script src="/js/materialize.min.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        M.FormSelect.init(document.querySelectorAll('select'), {});
    });
</script>

</body>
</html>