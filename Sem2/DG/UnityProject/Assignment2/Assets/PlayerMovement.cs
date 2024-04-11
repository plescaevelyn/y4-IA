using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMovement : MonoBehaviour
{
    private Rigidbody rb;
    private float verticalControl;
    private float horizontalControl;
    public float forceVertical;
    public float forceStrength;

    private bool isGrounded = true;

    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody>();
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        verticalControl = Input.GetAxis("Vertical");
        rb.AddForce(Vector3.forward * verticalControl * forceStrength);

        horizontalControl = Input.GetAxis("Horizontal");
        rb.AddForce(Vector3.right * horizontalControl * forceStrength);

        if (Input.GetKey(KeyCode.Space) && isGrounded)
        {
            rb.AddForce(Vector3.up * forceVertical);
            isGrounded = false;
        }
    }

    private void OnTriggerEnter(Collider other)
    {
        isGrounded = true;
    }
}
