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
        <div class="card-content center">
          <#if registeredTenantId??>
            <div class="row">
              <h6 class="grey-text text-darken-4">Success!</h6>
              <h6 class="grey-text text-darken-4">Here is a link to your service:</h6>
            </div>
            <div class="row center">
              <a href="/barbershop?tenantId=${registeredTenantId}">http://localhost:8080/barbershop?tenantId=${registeredTenantId}</a>
            </div>
          <#else>
            <form method="post" action="/register">
              <div class="row">
                <h6 class="grey-text text-darken-4">Register your dream barbershop</h6>
              </div>
              <div class="row">
                <div class="col s1 m1 l2"></div>
                <div class="form-label col s4 m4 l3">
                  <label for="tenantId">Tenant ID</label>
                </div>
                <div class="input-field col s6 m6 l5">
                  <input placeholder="Enter your tenant ID" id="tenantId" name="tenantId" type="text">
                </div>
                <div class="col s1 m1 l2"></div>
              </div>
              <div class="row">
                <div class="col s1 m1 l2"></div>
                <div class="form-label col s4 m4 l3">
                  <label for="barbers">Barbers</label>
                </div>
                <div class="input-field col s6 m6 l5">
                  <input placeholder="Enter your barbers, comma separated" id="barbers" name="barbers" type="text">
                </div>
                <div class="col s1 m1 l2"></div>
              </div>
              <div class="row">
                <div class="col s1 m4 l5"></div>
                <div class="col s10 m4 l2 center">
                  <button class="btn-large waves-effect waves-light" type="submit" name="action">Register
                  </button>
                </div>
                <div class="col s1 m4 l5"></div>
              </div>
            </form>
          </#if>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="/js/materialize.min.js"></script>

</body>
</html>
