import { useRequest } from 'ahooks';
import { Form, Modal, Input, notification } from 'antd';
import React, { useEffect } from 'react';
import { fetchAddTenant, fetchUpdateTenant } from './service';

interface IProps {
  type: string;
  data: any;
  visible: boolean;
  onClose: () => void;
  reset: () => void;
}

const TenantCreate: React.FC<IProps> = props => {
  const { visible, onClose, data, type, reset } = props;
  const [form] = Form.useForm();
  const updateRequest = useRequest(fetchUpdateTenant, {
    manual: true,
    onSuccess: () => {
      notification.success({ message: '更新成功' });
      form.resetFields();
      onClose();
      reset();
    },
    onError: err => {
      notification.error({ message: err.message });
    },
  });
  const addRequest = useRequest(fetchAddTenant, {
    manual: true,
    onSuccess: () => {
      notification.success({ message: '创建成功' });
      form.resetFields();
      onClose();
      reset();
    },
    onError: err => {
      notification.error({ message: err.message });
    },
  });
  const onSave = () => {
    form
      .validateFields()
      .then(values => {
        addRequest.run({ ...values });
      })
      .catch(info => {
        console.log('Validate Failed:', info);
      });
  };
  const onUpdate = () => {
    form
      .validateFields()
      .then(values => {
        updateRequest.run({ id: data.id, ...values });
      })
      .catch(info => {
        console.log('Validate Failed:', info);
      });
  };
  useEffect(() => {
    if (type === 'edit') {
      form.setFieldsValue({
        ...data,
      });
    }
  }, [type, data, form]);

  return (
    <Modal
      open={visible}
      onCancel={onClose}
      width={600}
      title={type === 'edit' ? '编辑' : '创建'}
      onOk={type === 'edit' ? onUpdate : onSave}
      confirmLoading={addRequest.loading || updateRequest.loading}
    >
      <Form labelAlign="right" labelCol={{ span: 6 }} wrapperCol={{ span: 15 }} form={form}>
        <Form.Item label="租户" name="tenantId" rules={[{ required: true }]}>
          <Input placeholder="请输入" disabled={type === 'edit'} />
        </Form.Item>
        <Form.Item label="租户名称" name="tenantName" rules={[{ required: true }]}>
          <Input placeholder="请输入" />
        </Form.Item>
        <Form.Item label="负责人" name="owner" rules={[{ required: true }]}>
          <Input placeholder="请输入" />
        </Form.Item>
        <Form.Item label="租户简介" name="tenantDesc" rules={[{ required: true }]}>
          <Input.TextArea placeholder="请输入" />
        </Form.Item>
      </Form>
    </Modal>
  );
};

export default TenantCreate;
