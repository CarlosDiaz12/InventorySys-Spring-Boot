  const ddlDestinationStore = document.getElementById('destinationStore');
  const ddlItem = document.getElementById('item');
  const ddlTransactionType = document.getElementById('transactionType');

  ddlTransactionType.addEventListener('change', (event) => {
  if(event.target.value == "0") {
        fetchStoresById(ddlItem.value);
  }

    if(event.target.value == "TRANSFER") {
    ddlDestinationStore.disabled = false;
    if(ddlItem.value == "0")
        return;

     fetchNotInStoreById(ddlItem.value);
    } else{
        ddlDestinationStore.disabled = true;
        ddlDestinationStore.length = 0;
        addDefaultElement(ddlDestinationStore);

        if((event.target.value == "IN")) {
            fetchAllStores();
        } else {
            fetchStoresById(ddlItem.value);
        }
    }
  });

    ddlItem.addEventListener('change', (event) => {
      ddlTransactionType.value = 0;
      ddlDestinationStore.length = 0;
      ddlDestinationStore.disabled = true;
      addDefaultElement(ddlDestinationStore);

       fetchStoresById(event.target.value);

    });


    function fetchStoresById(itemId) {
    fetch(`/api/item/${itemId}/stores`)
            .then((response) => response.json())
            .then((data) => {
                  const ddlStore = document.getElementById('store');
                  ddlStore.options.length = 0;
                  addDefaultElement(ddlStore);
                    data.forEach(store => {
                        var opt = store;
                        var el = document.createElement("option");
                        el.text = opt.description;
                        el.value = opt.id;
                        ddlStore.add(el);
                    });
            });}
    function fetchNotInStoreById(itemId) {
        fetch(`/api/item/${itemId}/not-in-stores`)
                .then((response) => response.json())
                .then((data) => {
                      const ddlStore = ddlDestinationStore;
                      ddlStore.options.length = 0;
                      addDefaultElement(ddlStore);
                        data.forEach(store => {
                            var opt = store;
                            var el = document.createElement("option");
                            el.text = opt.description;
                            el.value = opt.id;
                            ddlStore.add(el);
                        });
                });}
    function fetchAllStores() {
         fetch(`/api/store/all`)
                .then((response) => response.json())
                .then((data) => {
                      const ddlStore = document.getElementById('store');
                      ddlStore.options.length = 0;
                      addDefaultElement(ddlStore);
                        data.forEach(store => {
                            var opt = store;
                            var el = document.createElement("option");
                            el.text = opt.description;
                            el.value = opt.id;
                            ddlStore.add(el);
                        });
                });
    }
  function addDefaultElement(sourceElement) {
  // add default element
    const defaultElement = document.createElement("option");
    defaultElement.text = "Elige...";
    defaultElement.value = 0;
    sourceElement.add(defaultElement);
  }


